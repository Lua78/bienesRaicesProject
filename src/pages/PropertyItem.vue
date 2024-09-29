<template>
  <q-card class="q-mb-sm q-pa-sm small-card">
    <q-img :src="property.image" :alt="property.title" class="small-image" />
    <q-card-section class="q-pa-sm">
      <div class="text-subtitle2">{{ property.title }}</div>
      <div class="text-body2">{{ property.price }}</div>
      <q-chip dense icon="place" label="{{ property.location }}" />
      <q-chip dense color="green" icon="verified" label="Verificado" />
      <q-chip dense color="green" icon="check_circle" label="Disponible" v-if="property.available" />
    </q-card-section>
  </q-card>
</template>

<script>
export default {
  props: {
    property: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
.small-card {
  max-height: 400px; /* Ajusta la altura máxima de la tarjeta */
}

.small-image {
  height: 150px; /* Ajusta la altura de la imagen */
  object-fit: cover; /* Asegura que la imagen cubra su espacio correctamente */
}

.text-subtitle2 {
  font-size: 14px; /* Ajusta el tamaño del título */
}

.text-body2 {
  font-size: 12px; /* Ajusta el tamaño del texto del precio */
}

.q-chip {
  margin-top: 4px;
}
</style>
