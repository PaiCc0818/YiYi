<template>
  <div class="box">
    <CommodityCard v-if="isShow"/>
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
      commodity: [
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
    axios.get('/commodity/queryAllCommodityByLimit', {params: {page: '1'}}).then(res => {
      store.state.commodity = res.data
      // 先加载数据后渲染页面
      this.isShow = true
    })
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
  methods: {}
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