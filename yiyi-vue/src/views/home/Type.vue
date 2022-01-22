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
      commodityList: [],
    }
  },
  created() {
    this.getCommodityByType()
  },
  methods:{
    // 分类获取商品信息
    getCommodityByType(){
      axios.get("type/queryAllCommodityByTypeName",{params:{type:'1'}}).then(res=>{
        console.log(res)
      })
      console.log("分类获取商品信息")
    }
  },
}
</script>

<style scoped>

</style>