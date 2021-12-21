<template>
  <!--前台全局组件-->
  <UserNavMenu/>
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

</style>