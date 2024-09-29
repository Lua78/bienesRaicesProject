<template>
  <q-layout view="hHh lpR fFf">

    <q-header class="header text-white" height-hint="98">
      <q-toolbar>

        <q-input outlined dense v-model="searchQuery" placeholder="Buscar..." class="col-4" />
        <q-btn dense round flat icon="search" />
        <q-btn class="inputSearch" dense flat round label="Buscar por"
          @click="showPropertyOptions = !showPropertyOptions">
          <q-menu v-model="showPropertyOptions">
            <q-list>
              <q-item clickable v-ripple>
                <q-item-section avatar>
                  <q-icon name="home" />
                </q-item-section>
                <q-item-section>Casas</q-item-section>
              </q-item>
              <q-item clickable v-ripple>
                <q-item-section avatar>
                  <q-icon name="store" />
                </q-item-section>
                <q-item-section>Bodegas</q-item-section>
              </q-item>
              <q-item clickable v-ripple>
                <q-item-section avatar>
                  <q-icon name="apartment" />
                </q-item-section>
                <q-item-section>Departamentos</q-item-section>
              </q-item>
            </q-list>
          </q-menu>
        </q-btn>

        <div class="q-gutter-sm">
          <span>Rango de precios:</span>
          <q-range v-model="priceRange" :min="3000" :max="50000" />
        </div>

        <q-toggle v-model="onlyAvailable" label="Solo disponibles" class="q-ml-sm" />

      </q-toolbar>
    </q-header>

    <q-drawer show-if-above v-model="rightDrawerOpen" side="right" bordered>
      <!-- drawer content -->
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
        <q-img class="image-cover">
          <img src="/assets/logo.png">
        </q-img>

        <div>Real State</div>
        <div>globalrealState@algo.com</div>
        <div>+505 1456 0789</div>
      </div>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>

  </q-layout>
</template>

<script setup>
import { ref } from 'vue'

const leftDrawerOpen = ref(false)
const rightDrawerOpen = ref(false)
const searchQuery = ref('')
const showPropertyOptions = ref(false)
const priceRange = ref([3000, 40000])
const onlyAvailable = ref(false)

function toggleLeftDrawer() {
  leftDrawerOpen.value = !leftDrawerOpen.value
}
function toggleRightDrawer() {
  rightDrawerOpen.value = !rightDrawerOpen.value
}
</script>
<style lang="sass">
.header
  background-color: #1ABA1A
.image-cover
    width: 100%
    height: 100%
    object-fit: cover

.inputSearch
    padding-left: 25px
    border-radius: 8px

</style>
