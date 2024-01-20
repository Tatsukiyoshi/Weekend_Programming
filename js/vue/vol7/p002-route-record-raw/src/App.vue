<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <h3>Vue Routerのルート指定</h3>
  <ul>
    <li>
      <RouterLink to="/single">
        1つのコンポーネント（/single）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/single-with-children">
        1つのコンポーネントとn個の子要素（/single-with-children）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/single-with-children/child1">
        1つのコンポーネントとn個の子要素（/single-with-children/child1）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/single-with-children/child2">
        1つのコンポーネントとn個の子要素（/single-with-children/child2）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/multiple">
        n個のコンポーネント（/multiple）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/multiple-with-children">
        n個のコンポーネントとm個の子要素（/multiple-with-children）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/multiple-with-children/child1">
        n個のコンポーネントとm個の子要素（/multiple-with-children/child1）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/multiple-with-children/child2">
        n個のコンポーネントとm個の子要素（/multiple-with-children/child2）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/">
        別のパスへのリダイレクト（「/」から「/single」へ）
      </RouterLink>
    </li>
  </ul>
  <h3>Vue Routerの出力結果</h3>
  <div style="border:solid 1px black; padding: 10px;">
    <RouterView name="Header" /><!-- ヘッダーのRouterView -->
    <RouterView /><!-- デフォルトのRouterView -->
    <RouterView name="Footer" /><!-- フッターのRouterView -->
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
