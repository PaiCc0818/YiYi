<template>
  <!--全局背景-->
  <div class="background"/>
  <!--全局导航栏-->
  <UserNavMenu/>
  <!--主体-->
  <router-view/>
</template>

<script>
import UserNavMenu from "@/components/home/UserNavMenu";

export default {
  name: "Home",
  components: {UserNavMenu}
}
</script>

<style scoped>
.background {
  position: fixed;
  width: 100%;
  height: 100%;
  z-index: -1024;
  background-color: rgb(224, 231, 234);
}
</style>