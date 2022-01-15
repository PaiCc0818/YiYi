<template>
  <div class="box">
    <CommodityCard v-if="isShow"/>
    <div v-if="isFinish" class="finish">没有更多了！</div>
  </div>
</template>

<script>
import CommodityCard from "@/components/home/CommodityCard";
import store from "@/store";
import axios from "axios";

export default {
  name: "Index",
  components: {CommodityCard},
  data() {
    return {
      isShow: false,
      isFinish: false,
      commodityList: [],
    }
  },
  created() {
    this.getCommodity();
    this.checkWindow();
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
  }
}
</script>

<style scoped>
.box {
  margin: 30px auto;
  z-index: -1;
  width: 1200px;
  height: auto;
  background: white;
  padding: 30px 0;
  border-radius: 20px;
}

.finish {
  text-align: center;
  margin-top: 50px;
}
</style>