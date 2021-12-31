<template>
  <div class="box">
    <CommodityCard/>
    <button @click="toMy">转跳到登录</button>
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
}
</style>