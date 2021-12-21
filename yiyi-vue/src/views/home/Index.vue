<template>
  <h1>首页</h1><br>
  <button @click="toMy">转跳到登录</button>
</template>

<script>
import router from "@/router";

export default {
  name: "Index",
  methods: {
    toMy() {
      router.push('/login')
    }
  }
}
</script>

<style scoped>

</style>