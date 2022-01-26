<template>
  <h1>商品详情</h1>
  <h1>{{ this.$route.params.id }}</h1>
</template>

<script>
import axios from "axios";

export default {
  name: "Detail",
  data() {
    return {
      commodity: {
        commodityId: '',
        commodityTypeId: '',
        commodityUserId: '',
        commodityPicture: '',
        commodityDescribe: '',
        commodityPrice: '',
      }
    }
  },
  created() {
    axios.get('commodity/queryCommodityById', {params: {id: this.$route.params.id}}).then(res => {
      this.commodity = res.data
      console.log(this.commodity)
    })
  }
}
</script>

<style scoped>

</style>