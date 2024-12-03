<template>
  <q-card class="q-mb-sm q-pa-sm small-card row no-wrap">
    <q-img :src="image" :alt="property.title" class="small-image col-auto q-pa-md" />

    <q-card-section class=" dragElement  col">
      <div class="text-subtitle2">{{ property.name }}</div>
      <div class="text-body2">{{ property.price }}</div>
      <br>
      <q-chip class="q-pa-sm" dense icon="place" :label="property.address" />
      <br>
      <q-chip dense color="green" icon="verified" label="Verificado" />
      <br>
      <q-chip dense color="green" icon="check_circle" label="Disponible" v-if="property.active" />
      <div class="q-mt-md flex justify-between" style="padding: 0%;">

        <q-btn icon="visibility" class="rounded-borders" label="Ver" color="primary" @click="onViewClick" />
        <q-btn icon="edit" class="rounded-borders" label="Editar" color="green" @click="onEditClick" />
        <q-btn icon="delete" class="rounded-borders" label="Borrar" color="red" @click="onDeleteClick" />
      </div>
    </q-card-section>
  </q-card>
  <edit-property ref="editDialog" :property="property" />
  <view-property ref="viewDialog" :property="property" />
</template>

<script setup>
import editProperty from 'src/components/EditProperty.vue';
import ViewProperty from 'src/components/ViewProperty.vue';
import { ref, onMounted } from 'vue'

const editDialog = ref(null)
const viewDialog = ref(null)

const props = defineProps({
  property: {
    type: {
      Object
    },
    required: true
  }
});

const onViewClick = () => {
  viewDialog.value.openDialog()
}
const onEditClick = () => {
  editDialog.value.openDialog()
}
const image = ref('/assets/defaultHouse.webp')
onMounted(() => {
  const images = props.property.files
  if (images.length > 0) {
    image.value = images[0];
    console.log(images)
  }
})
</script>

<style scoped>
.small-card {
  width: 100%;
  display: flex;
}

.small-image {
  width: 300px;
  height: 190px;
  object-fit: cover;
  border-radius: 10px;
}

.q-card-section {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-self: start;
}

.text-subtitle2 {
  font-size: 14px;
  font-weight: bold;
}

.text-body2 {
  font-size: 18px;
  color: red;
}

.q-chip {
  margin-top: 4px;
}

.q-card {
  min-width: 500px !important;
}
</style>
