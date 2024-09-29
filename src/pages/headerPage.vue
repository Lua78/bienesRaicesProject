<template>
  <q-header class="bg-green-6 text-white">
    <q-toolbar>

      <q-input outlined dense v-model="searchQuery" placeholder="Buscar..." class="col-4" />

      <q-btn dense round flat icon="search" />

      <q-btn dense flat round label="Buscar por" @click="showPropertyOptions = !showPropertyOptions">
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
</template>

<script>
import { ref } from 'vue'

export default {
  setup() {
    const searchQuery = ref('')
    const showPropertyOptions = ref(false)
    const priceRange = ref([3000, 40000])
    const onlyAvailable = ref(false)

    return {
      searchQuery,
      showPropertyOptions,
      priceRange,
      onlyAvailable
    }
  }
}
</script>
