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
      </q-toolbar>
    </q-header>
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
