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
          option-label="name" class="q-ml-sm col-3 my-input" emit-value map-options item-value="idPropertyType"
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

        <q-select v-model="state" options-dense outlined dense :options="states" option-value="name"
          option-label="name" class="q-ml-sm col-3 my-input" emit-value map-options item-value="idPropertyState"
          :clearable="false">
          <template v-slot:option="item">
            <q-item v-bind="item.itemProps" clickable v-ripple class="clean">
              <q-item-section avatar>
                <q-icon :name="item.opt.icon" />
              </q-item-section>
              <q-item-section>{{ item.opt.name }}</q-item-section>
            </q-item>
          </template>

          <template v-slot:selected-item="item">
            <q-item v-bind="item.itemProps" class="clean">
              <q-item-section avatar class="clean">
                <q-icon :name="item.opt.icon" />
              </q-item-section>
              <q-item-section>{{ item.opt.name }}</q-item-section>
            </q-item>
          </template>
        </q-select>


      </q-toolbar>
    </q-header>

    <q-drawer show-if-above v-model="rightDrawerOpen" side="right" bordered>
      <div class="q-pa-md">
        <img src="/assets/logo.png" class="img-acoplada">

        <div>Real State</div>
        <div>globalrealState@algo.com</div>
        <div>+505 1456 0789</div>
      </div>
    </q-drawer>

    <q-page-container>
      <router-view :search-query="searchQuery" :type="filterBy" :state="state" />
    </q-page-container>
  </q-layout>
</template>

<script setup>
import { ref } from 'vue'

const rightDrawerOpen = ref(false)
const searchQuery = ref('')

const filterBy = ref({
  icon: "filter_list",
  name: "Tipo de propiedad",
  idPropertyType: null,
})

const state = ref({
  icon: "filter_list",
  name: "Estado de compra",
  idPropertyState: null
})

const options = [
  {
    icon: "filter_list",
    name: "Tipo de propiedad",
    idPropertyType: null,
  },
  {
    icon: "home",
    name: "Casa",
    idPropertyType: 1,

  },
  {
    icon: "store",
    name: "Bodega",
    idPropertyType: 2,
  },
  {
    icon: "build",
    name: "Edificio",
    idPropertyType: 2,
  },
  {
    icon: "apartment",
    name: "Departamento",
    idPropertyType: 3,
  }
]
const states = [
  {
    icon: "filter_list",
    name: "Estado de compra",
    idPropertyState: null
  },
  {
    icon: "home",
    name: "Venta",
    idPropertyState: 1,
  },
  {
    icon: "house",
    name: "Alquiler",
    idPropertyState: 2,
  },
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
  display: flex;
  max-height: 40px;
  align-content: center;
  flex-wrap: wrap;
  justify-content: center;
  align-items: stretch;
}

.my-search {
  display: flex;
  justify-content: space-between;
}

.mh2 {
  max-height: 45px;
}
</style>
