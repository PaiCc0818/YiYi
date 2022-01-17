<template>
  <div class="box">
    <CommodityCard v-if="isShow"/>
    <div v-if="isFinish" class="finish">没有更多了！</div>
  </div>
</template>

<script>
import CommodityCard from "@/components/home/CommodityCard";

export default {
  name: "Index",
  components: {CommodityCard},
  data() {
    return {
      isShow: false,
      isFinish: false,
      commodityList: [],
    }
  },
  created() {
    this.getCommodity();
    this.checkWindow();
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

.finish {
  text-align: center;
  margin-top: 50px;
}
</style>