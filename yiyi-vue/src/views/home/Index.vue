<template>
  <div class="box">
    <CommodityCard ref="child"/>
  </div>
</template>

<script>
import CommodityCard from "@/components/home/CommodityCard";

export default {
  name: "Index",
  components: {CommodityCard},
  data() {
    return {}
  },
  created() {
  },
  mounted() {
    window.onscroll = function () {
      //变量scrollTop是滚动条滚动时，距离顶部的距离
      const scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
      //变量windowHeight是可视区的高度
      const windowHeight = document.documentElement.clientHeight || document.body.clientHeight;
      //变量scrollHeight是滚动条的总高度
      const scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
      // 页面滚动接近底部加载数据
      if (scrollHeight - (scrollTop + windowHeight) < 100) {
        console.log("快到底了，赶紧加载数据！")
      }
    }
  },
  methods: {
    getCommodity() {

    }
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
</style>