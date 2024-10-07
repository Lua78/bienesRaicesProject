<template>
  <q-layout view="hHh lpR fFf">
    <q-header class="header text-white q-pa-md" height-hint="98">
      <q-toolbar class="justify-between">
        <div class="my-input my-search">
          <q-input outlined dense v-model="searchQuery" placeholder="Buscar..." class="mw col-4">
            <template v-slot:append>
              <q-btn flat round icon="search" />
            </template>
          </q-input>
        </div>

        <q-select v-model="filterBy" options-dense outlined dense :options="options" option-value="name"
          option-label="name" class="q-ml-sm col-3 my-input" emit-value map-options item-value="name"
          :clearable="false">
          <template v-slot:option="scope">
            <q-item v-bind="scope.itemProps" clickable v-ripple class="clean">
              <q-item-section avatar>
                <q-icon :name="scope.opt.icon" />
              </q-item-section>
              <q-item-section>{{ scope.opt.name }}</q-item-section>
            </q-item>
          </template>

          <template v-slot:selected-item="scope">
            <q-item v-bind="scope.itemProps" class="clean">
              <q-item-section avatar class="clean">
                <q-icon :name="scope.opt.icon" />
              </q-item-section>
              <q-item-section>{{ scope.opt.name }}</q-item-section>
            </q-item>
          </template>
        </q-select>

        <div class="q-ml-sm my-input mw">
          <span>Precio: {{ priceRange }}</span>
          <q-range v-model="priceRange" :min="3000" :max="40000" />
        </div>

        <q-toggle v-model="onlyAvailable" label="Solo disponibles" class="q-ml-sm my-input mw" />

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
        <img src="/assets/logo.png" class="img-acoplada">

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
const priceRange = ref([3000, 40000])
const onlyAvailable = ref(false)
const filterBy = ref({
  icon: "home",
  name: "Todos"
})

const options = [
  {
    icon: "home",
    name: "Todos"
  },
  {
    icon: "home",
    name: "Casas"
  },
  {
    icon: "store",
    name: "Bodegas"
  },
  {
    icon: "apartment",
    name: "Departamentos"
  }
]



</script>

<style scoped>
.header {
  background-color: #1ABA1A;
}

.img-acoplada {
  width: 100%;
  height: 200px;
  object-fit: cover;
  border-radius: 10px;
}

.inputSearch {
  padding-left: 25px;
  border-radius: 8px;
}

.mw {
  min-width: 300px;
}

.maw {
  max-width: 284px;
}

.my-input {
  color: black;
  background-color: white;
  border: none;
  border-radius: 10px;
}

.my-search {
  display: flex;
  justify-content: space-between;
}

.mh2 {
  max-height: 45px;
}
</style>
