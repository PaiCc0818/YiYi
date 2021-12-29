<template>
  <div class="commodity-list">
    <CommodityCard/>
  </div>
</template>
<script>
import CommodityCard from "@/components/home/CommodityCard";

export default {
  name: "Index",
  components: {CommodityCard},
  methods: {}
}
</script>

<style scoped>
.commodity-list {
  background: rgba(255, 255, 255);
  width: 1200px;
  position: relative;
  margin: 30px auto;
  z-index: -1;
}
</style>