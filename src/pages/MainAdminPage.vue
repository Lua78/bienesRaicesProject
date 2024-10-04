<template>
  <q-page>
    <q-list>
      <property-item-admin v-for="property in properties" :key="property.id" :property="property" />
    </q-list>

  </q-page>
</template>

<script setup>

import { ref } from 'vue'
import PropertyItemAdmin from './PropertyItemAdmin.vue';
const properties = ref([
  {
    id: 1,
    title: 'Casa de con dos cuartos y un baño',
    price: 'C$ 12000.00',
    type: 'Venta',
    location: 'Las Colinas, Managua',
    available: true,
    images: ['assets/casa.jpg','assets/apartamentos.jpg']
  },
  {
    id: 2,
    title: 'Apartamentos disponibles',
    price: 'C$ 1200.00',
    location: 'Metrocentro, Managua',
    type: 'Alquiler',
    available: true,
    images: ['assets/apartamentos.jpg']
  },
  {
    id: 3,
    title: 'Casa de con dos cuartos y un baño',
    price: 'C$ 12000.00',
    type: 'Venta',
    location: 'Las Colinas, Managua',
    available: true,
    images: ['assets/casa.jpg']
  },
  {
    id: 4,
    title: 'Apartamentos disponibles',
    price: 'C$ 1200.00',
    type: 'Alquiler',
    location: 'Metrocentro, Managua',
    available: true,
    images: []
  },
  // Agrega más propiedades aquí...
])

</script>

<style scoped></style>
