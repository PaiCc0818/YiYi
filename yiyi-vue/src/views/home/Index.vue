<template>
  <button @click="getCommodity">fdsafda</button>
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
    this.getCommodity();
  },

  methods: {
    // 请求商品基本信息，一次十个
    getCommodity() {
      axios.get('/commodity/queryAllCommodityByLimit', {params: {page: store.state.page}}).then(res => {
        if (res.data.length !== 0) {
          // 向store中写入数据
          store.state.commodity = res.data
          // 页面加一
          store.state.page++
          // 先加载数据后渲染页面
          this.isShow = true
        } else {
          console.log("已经结束了，没有了！")
        }
      })
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
</style>