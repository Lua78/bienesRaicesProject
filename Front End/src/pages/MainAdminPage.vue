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
    category: 'Casa',
    location: 'Las Colinas, Managua',
    available: true,
    images: ['assets/casa.jpg','assets/apartamentos.jpg']
  },
  {
    id: 2,
    title: 'Departamentos disponibles',
    price: 'C$ 1200.00',
    location: 'Metrocentro, Managua',
    type: 'Alquiler',
    category: 'Departamento',
    available: true,
    images: ['assets/apartamentos.jpg']
  },
  {
    id: 3,
    title: 'Casa de con dos cuartos y un baño',
    price: 'C$ 12000.00',
    category: 'Casa',
    type: 'Venta',
    location: 'Las Colinas, Managua',
    available: true,
    images: ['assets/casa.jpg']
  },
  {
    id: 4,
    title: 'Departamentos disponibles',
    price: 'C$ 1200.00',
    type: 'Alquiler',
    category: 'Departamento',
    location: 'Metrocentro, Managua',
    available: false,
    images: []
  },
])

</script>

<style scoped></style>
