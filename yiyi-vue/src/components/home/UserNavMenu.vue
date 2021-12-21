<template>
  <div>
    <!--进度条-->
    <div id="reading-progress-bar" style="width:0"></div>

    <!--导航栏-->
    <div v-if="nav">
      <div class="top"></div>
      <div class="nav-bar">
        <router-link v-for="(item,index) in navList" :key="index" :to="item.name" active-class="nav-menu-active"
                     class="nav-menu">
          <img :src="require('../../assets/svg/'+item.svg)" alt="">
          {{ item.navItem }}
        </router-link>
      </div>
    </div>

    <div v-if="!nav" id="small-nav" class="small-nav">
      <img alt="" src="src/assets/svg/list.svg" @click="navShow">
      <div class="small-nav-bar">
        <router-link
            v-for="(item,index) in navList" :key="index" :to="item.name"
            active-class="small-nav-menu-active"
            class="small-nav-menu"
            @click="navShow">
          {{ item.navItem }}
        </router-link>
      </div>
    </div>
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
      nav: '',
    }
  },
  // 组件创建完成
  mounted() {
    //监听页面滚动事件
    window.addEventListener('scroll', this.handleScroll, true);
    this.Switching();
  },
  watch: {
    // 如果路由有变化，会再次执行该方法 判断页面大小或路径变化
    '$route': 'Switching'
  },
  methods: {
    // 滚动条方法  页面滚动后执行
    handleScroll() {
      // 页面滚动距顶部距离
      const scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
      // 网页全文高度 - 网页可见区域高度
      let c = scrollTop / (document.body.scrollHeight - document.documentElement.clientHeight) * 100
      c += "%";
      document.getElementById("reading-progress-bar").style.width = String(c);
    },
    // 判断页面大小自适应方法
    Switching() {
      let w = document.documentElement.clientWidth || document.body.clientWidth
      this.nav = !(w <= 796 || this.$route.path.slice(0, 5) === "/blog");
    },

    navShow() {
      const nav = document.getElementById("small-nav");
      if (nav.offsetLeft === 0) {
        nav.style['margin-left'] = -270 + "px"
      } else {
        nav.style['margin-left'] = 0 + "px"
      }
    }
  },
}
</script>

<style scoped>
.top {
  padding-top: 50px
}

/*!* 进度条 *!*/
#reading-progress-bar {
  position: fixed;
  top: 0;
  background: #ef4e7b;
  height: 2px;
  z-index: 1024;
}

/*!* 导航栏 *!*/
.nav-bar {
  position: fixed;
  top: 0;
  height: 50px;
  width: 100%;
  background: rgba(0, 0, 0, 0.8);
  text-align: center;
  /*z-index: 1023;*/
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
</style>
