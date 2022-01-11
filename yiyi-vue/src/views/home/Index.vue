<template>
  <div class="box">
    <CommodityCard v-if="isShow"/>
  </div>
</template>

<script>
import CommodityCard from "@/components/home/CommodityCard";
import store from "@/store";
import axios from "axios";

export default {
  name: "Index",
  components: {CommodityCard},
  data() {
    return {
      isShow: false,
      isOVer: false,
      commodity: [
        {
          commodityId: '',
          commodityUserId: '',
          commodityTypeId: '',
          commodityPicture: '',
          commodityDescribe: '',
          commodityPrice: '',
        }
      ],
    }
  },
  created() {
    this.getCommodity();
    this.checkWindow();
  },

  methods: {
    // 请求商品基本信息，一次十个
    getCommodity() {
      axios.get('/commodity/queryAllCommodityByLimit', {params: {page: store.state.page}}).then(res => {
        if (res.data.length === 0) {
          this.isOVer = true;
          console.log("已经结束了，没有了！")
          return
        }
        // 向store中写入数据
        store.state.commodity = res.data
        // 先加载数据后渲染页面
        this.isShow = true
      })
    },

    // 监视窗口滚动
    checkWindow() {
      window.onscroll = function () {
        //变量scrollTop是滚动条滚动时，距离顶部的距离
        const scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
        //变量windowHeight是可视区的高度
        const windowHeight = document.documentElement.clientHeight || document.body.clientHeight;
        //变量scrollHeight是滚动条的总高度
        const scrollHeight = document.documentElement.scrollHeight || document.body.scrollHeight;
        // 页面滚动接近底部加载数据
        if (scrollHeight - (scrollTop + windowHeight) < 500) {
          // 没有数据后，不触发请求
          if (!this.isOVer) {
            this.getCommodity()
          }
          store.state.page++
          console.log("快到底了，赶紧加载数据！")
        }
      }
    },
  }

  // methods: {
  //   getSingerList() {
  //     this.$api.getSinger({
  //       limit: 20,
  //       offset: this.offset
  //     }).then(res => {
  //       if (res.artists.length === 0) {
  //         // 显示已经到底了
  //         this.isShow = true
  //         return
  //       }
  //       // 偏移量
  //       this.offset += 20
  //       // 合并结果
  //       this.singerList = [...this.singerList, ...res.artists]
  //     })
  //   },
  //
  //   // 请求商品基本信息，一次十个
  //   getCommodity() {
  //     axios.get('/commodity/queryAllCommodityByLimit', {params: {page: store.state.page}}).then(res => {
  //       if (res.data.length===0){
  //         return
  //       }
  //       store.state.commodity = res.data
  //       // 先加载数据后渲染页面
  //       this.isShow = true
  //       console.log(res.data)
  //     })
  //   },
  //
  //   // 触底触发函数
  //   listenBottomOut() {
  //     const scrollTop = document.documentElement.scrollTop || document.body.scrollTop
  //     const clientHeight = document.documentElement.clientHeight
  //     const scrollHeight = document.documentElement.scrollHeight
  //     if (scrollTop + clientHeight >= scrollHeight) {
  //       // 没有数据后，不触发请求
  //       if (!this.isShow) {
  //         this.getCommodity()
  //
  //       }
  //     }
  //   }
  // },
  // created() {
  //   // 预先加载一遍
  //   this.getCommodity()
  // },
  // mounted() {
  //   // 事件监听
  //   window.addEventListener('scroll', this.listenBottomOut)
  // }
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
</style>