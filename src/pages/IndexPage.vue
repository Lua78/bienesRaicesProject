<template>
  <q-page class="flex flex-center">

      <q-list>
        <q-item clickable v-ripple>
          <q-item-section>Más populares</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>Mejor oferta</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>Solo Venta</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>Solo Alquiler</q-item-section>
        </q-item>
      </q-list>
      <div class="q-pa-md">
        <q-avatar>
          <img src="https://cdn.quasar.dev/logo-v2/svg/logo-mono-white.svg">
        </q-avatar>
        <div>Real State</div>
        <div>globalrealState@algo.com</div>
        <div>+505 1456 0789</div>
      </div>

  </q-page>
</template>

<script setup>
defineOptions({
  name: 'IndexPage'
});
</script>
