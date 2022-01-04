<template>
  <!--商品标签叶卡片-->
  <div class="commodity-card" @click="toDetails">
    <div class="commodity-picture">
      <img alt="" src="../../assets/1.jpg">
    </div>
    <div class="commodity-details">
      <div class="introduce">这是一件商品你sdfsgfdsafsafafg想买就买gsdfgs不买拉到</div>
      <div class="money"><em>¥ </em>10</div>
    </div>
  </div>
  <div class="commodity-card" @click="toDetails">
    <div class="commodity-picture">
      <img alt="" src="../../assets/1.jpg">
    </div>
    <div class="commodity-details">
      <div class="introduce">这是一件商品你sdfsgfdsafsafafg想买就买gsdfgs不买拉到</div>
      <div class="money"><em>¥ </em>10</div>
    </div>
  </div>
  <div class="commodity-card" @click="toDetails">
    <div class="commodity-picture">
      <img alt="" src="../../assets/1.jpg">
    </div>
    <div class="commodity-details">
      <div class="introduce">这是一件商品你sdfsgfdsafsafafg想买就买gsdfgs不买拉到</div>
      <div class="money"><em>¥ </em>10</div>
    </div>
  </div>
  <div class="commodity-card" @click="toDetails">
    <div class="commodity-picture">
      <img alt="" src="../../assets/1.jpg">
    </div>
    <div class="commodity-details">
      <div class="introduce">这是一件商品你sdfsgfdsafsafafg想买就买gsdfgs不买拉到</div>
      <div class="money"><em>¥ </em>10</div>
    </div>
  </div>
  <div class="commodity-card" @click="toDetails">
    <div class="commodity-picture">
      <img alt="" src="../../assets/1.jpg">
    </div>
    <div class="commodity-details">
      <div class="introduce">这是一件商品你sdfsgfdsafsafafg想买就买gsdfgs不买拉到</div>
      <div class="money"><em>¥ </em>10</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CommodityCard",

  methods: {

    toDetails() {
      alert("转跳到详情页")
    }
  }
}
</script>

<style scoped>
.commodity-card {
  background: #ffffff;
  display: inline-block;
  margin: 5px;
  padding: 5px;
  width: 230px;
  height: 330px;
  border-radius: 10px;
  cursor: pointer;
}

.commodity-card:hover {
  box-shadow: 0 2px 27px 6px rgba(0, 0, 0, .12);
}

.commodity-picture img {
  height: 220px;
  border-radius: 10px;
}

.introduce {
  white-space: normal;
  word-break: break-all;
  overflow: hidden;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}

.money {
  color: rgb(255, 68, 0);
}
</style>