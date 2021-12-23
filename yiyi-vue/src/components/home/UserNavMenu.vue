<template>
  <!--导航栏-->
  <div class="top"></div>
  <div class="nav-bar">
    <router-link v-for="(item,index) in navList" :key="index" :to="item.name" active-class="nav-menu-active"
                 class="nav-menu">
      <img :src="require('../../assets/svg/'+item.svg)" alt="">
      {{ item.navItem }}
    </router-link>
  </div>
</template>
<script>
export default {
  name: 'UserNavMenu',
  data() {
    return {
      navList: [
        {name: '/index', navItem: '首页', svg: 'home.svg'},
        {name: '/type', navItem: '分类', svg: 'type.svg'},
        {name: '/release', navItem: '发布', svg: 'release.svg'},
        {name: '/message', navItem: '消息', svg: 'messages.svg'},
        {name: '/my', navItem: '我的', svg: 'my.svg'}
      ],
    }
  },

  created() {},

  methods: {},
}
</script>

<style scoped>
.top {
  padding-top: 50px
}

/*!* 导航栏 *!*/
.nav-bar {
  position: fixed;
  /*top: 0;*/
  bottom: 0;
  height: 50px;
  width: 100%;
  background: rgba(0, 0, 0, 0.8);
  text-align: center;
}

/* 导航栏按钮 */
.nav-menu {
  text-decoration: none;
  color: rgba(255, 255, 255, 0.6);
  padding: 5px 20px;
  line-height: 50px;
}

.nav-menu img {
  width: 15px;
  filter: invert(100%);
  margin-right: 10px;
}

/*选中显示样式*/
.nav-menu-active {
  text-decoration: none;
  background-color: rgba(255, 255, 255, 0.2);
  border-radius: 25px;
  color: #ffffff;
  line-height: 50px;
  padding: 5px 20px;
  margin: 20px;
}

@media screen and (max-width: 1000px) {
  .nav-bar{
    background-color: #66afe9;
    position: fixed;
    bottom: 0;
  }
}
</style>
