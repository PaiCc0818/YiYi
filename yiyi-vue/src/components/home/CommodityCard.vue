<template>
  <!--商品标签叶卡片-->
  <div class="commodity-card">
    <div class="commodity-picture">

    </div>
    <div class="commodity-details">
      <div class="introduce">这是一件商品你想买就买不买拉到</div>
      <div class="money">10元</div>
    </div>
  </div>
  <div class="commodity-card">
    <div class="commodity-picture"></div>
    <div class="commodity-details">
      <span>nfndsafsdafsdadgadsa</span>
      <span></span>
    </div>
  </div>
  <div class="commodity-card">
    <div class="commodity-picture"></div>
    <div class="commodity-details">
      <span>nfndsafsdafsdadgadsa</span>
      <span></span>
    </div>
  </div>
  <div class="commodity-card">
    <div class="commodity-picture"></div>
    <div class="commodity-details">
      <span>nfndsafsdafsdadgadsa</span>
      <span></span>
    </div>
  </div>
  <div class="commodity-card">
    <div class="commodity-picture"></div>
    <div class="commodity-details">
      <span>nfndsafsdafsdadgadsa</span>
      <span></span>
    </div>
  </div>
  <div class="commodity-card">
    <div class="commodity-picture"></div>
    <div class="commodity-details">
      <span>nfndsafsdafsdadgadsa</span>
      <span></span>
    </div>
  </div>
</template>

<script>
export default {
  name: "CommodityCard"
}
</script>

<style scoped>
.commodity-card {
  background: #326705;
  display: inline-block;
  margin: 20px;
  padding: 5px;
  width: 200px;
  height: 330px;
  border-radius: 10px;
  cursor: pointer;
}

.commodity-details {
  white-space: normal;
  word-break: break-all;
  overflow: hidden;
}
</style>