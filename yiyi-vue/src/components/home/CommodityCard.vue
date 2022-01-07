<template>
  <!--商品标签叶卡片-->
  <div class="commodity-card" @click="toDetails" v-for="(item,index) in commodity" :key="index">
    <div class="commodity-picture">
      <img alt="" v-bind:src="item.commodityPicture">
    </div>
    <div class="commodity-details">
      <div class="introduce">{{item.commodityDescribe}}</div>
      <div class="money"><em>¥ </em>{{item.commodityPrice}}</div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CommodityCard",

  data() {
    return {
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
      this.commodity = res.data
      console.log(this.commodity)
    })
  },
  methods: {
    toDetails() {
      alert("转跳到详情页")
    }
  }
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
}

.commodity-card:hover {
  box-shadow: 0 2px 27px 6px rgba(0, 0, 0, .12);
}

.commodity-picture img {
  height: 220px;
  width: 220px;
  border-radius: 10px;
}

.introduce {
  height: 70px;
  white-space: normal;
  word-break: break-all;
  overflow: hidden;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}

.money {
  color: rgb(255, 68, 0);
}
</style>