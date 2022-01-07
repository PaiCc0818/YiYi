<template>
  <div class="box">
    <CommodityCard/>
    <CommodityCard/>
    <CommodityCard/>
    <CommodityCard/>
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
    let _this = this;
    let page = 0
    window.onscroll = function () {
      //变量scrollTop是滚动条滚动时，距离顶部的距离
      const scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
      //变量windowHeight是可视区的高度
      const windowHeight = document.documentElement.clientHeight || document.body.clientHeight;
      //变量scrollHeight是滚动条的总高度
      const scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
      //滚动条到底部的条件
      if (scrollTop + windowHeight === scrollHeight) {
        //到了这个就可以进行业务逻辑加载后台数据了
        _this.isBottom = true;
        page++
        console.log(page)
        console.log("到了底部");
      } else {
        _this.isBottom = false;
      }
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