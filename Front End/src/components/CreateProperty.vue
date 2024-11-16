<template>
  <q-dialog v-model="dialog" persistent style="min-width: 500px;">
    <q-card class="q-pa-md aaa" style="width: 500px;">
      <q-card-section>
        <div class="text-h6">Agregar una Propiedad</div>
      </q-card-section>

      <q-form @submit="onSubmit" @reset="onReset" style="min-width: 450px;">
        <!-- Título -->
        <q-card-section>
          <q-input v-model="propertyData.title" label="Nombre de la propiedad" filled />
        </q-card-section>

        <!-- Precio -->
        <q-card-section>
          <q-input v-model="propertyData.price" label="Precio" filled />
        </q-card-section>

        <!-- Tipo -->
        <q-card-section>
          <q-select v-model="propertyData.type" :options="['Venta', 'Alquiler']" label="Tipo" filled />
        </q-card-section>

        <!-- Categoria -->
        <q-card-section>
          <q-select v-model="propertyData.type" :options="['Casa', 'Bodega', 'Departamento']" label="Categoria" filled />
        </q-card-section>

        <!-- Ubicación -->
        <q-card-section>
          <q-input v-model="propertyData.location" label="Ubicación" filled />
        </q-card-section>

        <!-- Disponible -->
        <q-card-section>
          <q-toggle v-model="propertyData.available" label="Disponible" />
        </q-card-section>

        <!-- Subir imágenes -->
        <q-card-section>
          <q-file v-model="images" label="Subir imágenes" filled multiple />
        </q-card-section>

        <!-- Botones -->
        <q-card-actions align="right">
          <q-btn flat label="Cancelar" color="negative" @click="onCancel" />
          <q-btn type="submit" label="Guardar" color="primary" />
        </q-card-actions>
      </q-form>
    </q-card>
  </q-dialog>
</template>

<script setup>
import { ref } from 'vue'
const dialog = ref(false)
const propertyData = ref({
  id: null,
  title: '',
  price: 0,
  type: '',
  location: '',
  available: false,
  images: []
})
const images = ref([])
function openDialog() {
  dialog.value = true;
}
const closeDialog = () => {
  dialog.value = false;
}
const onSubmit = () => {
  const create = () => {
    console.log('send')
  };

  console.log('Datos enviados:', create);

  // Lógica para enviar los datos al servidor (ejemplo con axios)
  // axios.post('tu-endpoint', updatedProperty)
  //   .then(response => console.log('Datos guardados:', response))
  //   .catch(error => console.error('Error al guardar los datos:', error));

  closeDialog()
}
const onReset = () => {
  propertyData.value = {
    id: null,
    title: '',
    price: 0,
    type: '',
    location: '',
    available: true,
    images: []
  }
}
const onCancel = () => {
  onReset;
  closeDialog();
}
defineExpose({ openDialog });
</script>

<style scoped>
.q-card-section {
  padding: 16px;
  min-width: 500px;
}

.q-field__native {
  width: 500px !important;
}
</style>
