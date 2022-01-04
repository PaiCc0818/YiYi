<template>
  <div class="box">
    <CommodityCard/>
  </div>
</template>

<script>
import router from "@/router";
import CommodityCard from "@/components/home/CommodityCard";

export default {
  name: "Index",
  components: {CommodityCard},
  methods: {
    toMy() {
      router.push('/login')
    }
  }
}
</script>

<style scoped>
.box {
  position: absolute;
  left: 0;
  right: 0;
  margin: 50px auto;
  z-index: -1;
  width: 1200px;
  height: auto;
  min-height: 100%;
  background: white;
  padding: 30px 0;
}
</style>