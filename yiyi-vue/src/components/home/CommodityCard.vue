<template>
  <!--商品标签叶卡片-->
  <div v-for="(item,index) in commodityList" :key="index" class="commodity-card" @click="toDetails">
    <div class="commodity-picture">
      <img alt="" v-bind:src="item.commodityPicture">
    </div>
    <div class="commodity-details">
      <div class="introduce">{{ item.commodityDescribe }}</div>
      <div class="money"><em>¥ </em>{{ item.commodityPrice }}</div>
    </div>
  </div>
</template>

<script>
import store from "@/store";
import axios from "axios";

export default {
  name: "CommodityCard",

  data() {
    return {
      commodityList: [
        {
          commodityId: '',
          commodityUserId: '',
          commodityTypeId: '',
          commodityPicture: '',
          commodityDescribe: '',
          commodityPrice: '',
        }
      ],
    }
  },
  created() {
    // 通过store获取商品信息
    this.commodityList = store.state.commodityList
  },
  methods: {
    // 请求商品基本信息，一次十个
    getCommodity() {
      axios.get('/commodity/queryAllCommodityByLimit', {params: {page: store.state.page}}).then(res => {
        console.log(res.data)
        if (res.data.length !== 0) {
          // 先将数据合并存储
          for (let i = 0; i < res.data.length; i++) {
            this.commodityList.push(res.data[i])
          }
          // 向store中写入数据
          store.state.commodityList = this.commodityList
          // 页面加一
          store.state.page++
          // 先加载数据后渲染页面
          this.isShow = true
        } else {
          this.isFinish = true
          console.log("数据加载完了！")
        }
      })
    },

    // 监视窗口滚动
    checkWindow() {
      // 提升全局变量
      let _this = this;
      // 监视窗口滚动
      window.onscroll = function () {
        // 变量scrollTop是滚动条滚动时，距离顶部的距离
        const scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
        // 变量windowHeight是可视区的高度
        const windowHeight = document.documentElement.clientHeight || document.body.clientHeight;
        // 变量scrollHeight是滚动条的总高度
        const scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
        // 滚动条到接近底部的条件
        if (scrollHeight - (scrollTop + windowHeight) < 200) {
          setTimeout(() => {
            if (!_this.isFinish) {
              _this.getCommodity();
            }
          }, 100);
        }
      }
    },

    // 转跳到详情页
    toDetails() {
      alert("转跳到详情页")
    },
  },

}
</script>

<style scoped>
.commodity-card {
  background: #ffffff;
  display: inline-block;
  margin: 5px;
  padding: 5px;
  width: 230px;
  height: 330px;
  border-radius: 10px;
  cursor: pointer;
  box-shadow: 0 1px 20px 1px rgba(0, 0, 0, 0.07);
}

.commodity-card:hover {
  box-shadow: 0 2px 27px 10px rgba(0, 0, 0, 0.2);
}

.commodity-picture img {
  height: 220px;
  width: 220px;
  border-radius: 10px;
}

.commodity-details {
  padding: 5px 10px;
}

.introduce {
  height: 60px;
  overflow: hidden;
}

.money {
  color: rgb(255, 68, 0);
}
</style>