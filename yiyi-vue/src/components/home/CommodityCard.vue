<template>
  <!--商品标签叶卡片-->
  <div v-for="(item,index) in commodityList" :key="index" class="commodity-card" @click="toDetails(item.commodityId)">
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

import router from "@/router";

export default {
  name: "CommodityCard",
  props: ['child'],
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
    this.commodityList = this.child
  },

  methods: {
    // 转跳到详情页
    toDetails(id) {
      router.push({
        path: `/detail/${id}`,
      });
    },
  },
  watch: {
    child(val, oldVal) {
      if (val !== oldVal) {
        this.commodityList = this.child
        console.log(val)
      }
    }
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
  height: 47px;
  overflow: hidden;
  margin: 10px 0;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}

.money {
  color: rgb(255, 68, 0);
}
</style>