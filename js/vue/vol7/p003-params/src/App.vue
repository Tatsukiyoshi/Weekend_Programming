<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <h3>Vue Routerのルート指定（パラメーター渡し）</h3>
  <ul>
    <li><RouterLink to="/fruit1/Apple/300/5">route渡し（/fruit1/Apple/300/5）</RouterLink></li>
    <li><RouterLink to="/fruit2/Orange/400/2">props渡し（/fruit2/Orange/400/2）</RouterLink></li>
  </ul>
  <h3>Vue Routerの出力結果</h3>
  <div style="border:1px solid black">
    <RouterView />
  </div>
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>

