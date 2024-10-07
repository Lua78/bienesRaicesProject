<template>
  <q-dialog v-model="dialog" persistent style="min-width: 500px;">
    <q-card class="q-pa-md aaa" style="width: 500px;">
      <q-card-section>
        <div class="text-h6">Editar Propiedad</div>
      </q-card-section>

      <q-form @submit="onSubmit" @reset="onReset" style="min-width: 450px;">
        <!-- Título -->
        <q-card-section>
          <q-input v-model="propertyData.title" label="Título" filled />
        </q-card-section>

        <!-- Precio -->
        <q-card-section>
          <q-input v-model="propertyData.price" label="Precio" filled />
        </q-card-section>

        <!-- Tipo -->
        <q-card-section>
          <q-select v-model="propertyData.type" :options="['Venta', 'Alquiler']" label="Tipo" filled />
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

<script>
export default {
  props: {
    property: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      dialog: false,
      propertyData: { ...this.property },
      images: []
    };
  },
  methods: {
    openDialog() {
      this.dialog = true;
    },
    closeDialog() {
      this.dialog = false;
    },
    onSubmit() {
      const updatedProperty = {
        ...this.propertyData,
        imagesList: this.images
      };

      console.log('Datos enviados:', updatedProperty);

      // Lógica para enviar los datos al servidor (ejemplo con axios)
      // axios.post('tu-endpoint', updatedProperty)
      //   .then(response => console.log('Datos guardados:', response))
      //   .catch(error => console.error('Error al guardar los datos:', error));

      this.closeDialog();
    },
    onReset() {
      this.propertyData = { ...this.property };
      this.images = [];
    },
    onCancel() {
      this.onReset();
      this.closeDialog();
    }
  }
};
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
