<template>
  <div class="main">
    <!-- 左侧导航 -->
    <div class="left-navigation">
      <div class="nav-menu">男装</div>
      <div class="nav-menu">男装</div>
      <div class="nav-menu">男装</div>
    </div>
    <!-- 商品 -->
    <div class="box">
      <CommodityCard :child="commodityList"/>
    </div>
  </div>
</template>

<script>
import CommodityCard from "@/components/home/CommodityCard";
import axios from "axios";

export default {
  name: "Type",
  components: {CommodityCard},
  data() {
    return {
      type: {
        typeId: '',
        typeName: '',
        typeCreateTime: '',
        commodityList: [],
      },
      commodityList: [
        {
          commodityId: '',
          commodityTypeId: '',
          commodityUserId: '',
          commodityPicture: '',
          commodityDescribe: '',
          commodityPrice: '',
        }
      ],
    }
  },
  created() {
    this.getCommodityByType()
  },
  methods: {
    // 分类获取商品信息
    getCommodityByType() {
      axios.get("type/queryAllCommodityByTypeName", {params: {typeName: '男装'}}).then(res => {
        this.type = res.data;
        console.log(res.data)
        console.log(this.type)
        console.log(this.type.typeId)
      })
    }
  },
}
</script>

<style scoped>
.main {
  background-color: #66afe9;
  position: relative;
  margin: 30px auto;
  width: 1710px;
  overflow: hidden;
  z-index: -1;
}

.left-navigation {
  background-color: #326705;
  position: fixed;
  float: left;
  width: 500px;
}

.box {
  float: right;
  width: 1200px;
  height: auto;
  background: white;
  padding: 30px 0;
  border-radius: 20px;
}
</style>