<template>
  <h1>分类</h1>
  <div>
    <CommodityCard :child="commodityList"/>
  </div>
</template>

<script>
import CommodityCard from "@/components/home/CommodityCard";
import axios from "axios";

export default {
  name: "Type",
  components: {CommodityCard},
  data(){
    return{
      type: {
        typeId: '',
        typeName: '',
        typeCreateTime: '',
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
      },
    }
  },
  created() {
    this.getCommodityByType()
  },
  methods:{
    // 分类获取商品信息
    getCommodityByType() {
      axios.get("type/queryAllCommodityByTypeName", {params: {typeName: '男装'}}).then(res => {
        this.type = res.data;
        console.log(this.type)
        console.log(res.data.commodityList)
        console.log(this.type.commodityList)
      })
      console.log("分类获取商品信息")
    }
  },
}
</script>

<style scoped>

</style>