<template>
  <div class="error">
    <div class="title">
      <slot></slot> <!-- 名前なしスロット -->
    </div>
    <div class="description">
      <slot name="desc"></slot> <!-- 名前付きスロット -->
    </div>
  </div>
</template>
<style scoped>
.error {
  background-color: black;
  color: yellow;
}

.error .title {
  font-size: 20pt;
  font-weight: bold;
}

.error .description {
  font-size: 10pt;
  font-weight: normal
}
</style>