<template>
  <div class="box">
    <CommodityCard :child="commodityList"/>
    <div v-if="isFinish" class="finish">没有更多了！</div>
  </div>
</template>

<script>
import CommodityCard from "@/components/home/CommodityCard";
import axios from "axios";

export default {
  name: "Index",
  components: {CommodityCard},
  data() {
    return {
      isFinish: false,
      page: 1,
      commodityList: [],
    }
  },
  created() {
    this.getCommodity();
    this.checkWindow();
  },
  methods: {
    // 请求商品基本信息，一次十五个
    getCommodity() {
      axios.get('/commodity/queryAllCommodityByLimit', {params: {page: this.page}}).then(res => {
        console.log(res.data.length)
        if (res.data.length !== 15) {
          for (let i = 0; i < res.data.length; i++) {
            this.commodityList.push(res.data[i])
          }
          this.isFinish = true
          return null;
        } else {
          for (let i = 0; i < res.data.length; i++) {
            this.commodityList.push(res.data[i])
          }
          // 页面加一
          this.page++
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
        if (scrollHeight - (scrollTop + windowHeight) < 500) {
          if (!_this.isFinish) {
            _this.getCommodity();
          }
        }
      }
    },
  },
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