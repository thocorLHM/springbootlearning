<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <input v-model="number" placeholder="Bitte Zahl Eingeben">
      </v-col>
      <v-col cols="12">
        <button id="starter" @click="startService">{{number}} wird übertragen</button>
      </v-col>
      <v-col class="mb-4">
        <h5>
          Willkommen beim RefArch-Kickstarter
        </h5>
        <p>
          {{number}} zum Quadrat ist:
          <span> {{result}} </span>
        </p>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue";

import HealthService from "@/api/HealthService";
import { useSnackbarStore } from "@/stores/snackbar";
import HealthState from "@/types/HealthState";
import { API_BASE} from "@/Constants";
import FetchUtils from "@/api/FetchUtils";

const snackbarStore = useSnackbarStore();
const status = ref("DOWN");
const number = ref();
const result = ref();

onMounted(() => {
  HealthService.checkHealth()
    .then((content: HealthState) => (status.value = content.status))
    .catch((error) => {
      snackbarStore.showMessage(error);
    });
});

function startService() {
  if (!number.value) {
    // eslint-disable-next-line no-console
    console.error("Die Nummer ist nicht definiert.");
    return;
  }
  const url = `${API_BASE}/cal?number=${encodeURIComponent(number.value)}`;
  fetch(url, FetchUtils.getGETConfig())
    .then((response) => {
      FetchUtils.defaultResponseHandler(
        response,
        `Beim Laden des Textes ist ein Fehler aufgetreten.  ${response.status}`
      );
      return response.text();
    })
    .then((text) => {
      result.value = text; // Ergebnis in `result` speichern
    })
    .catch((error) => {
      // eslint-disable-next-line no-console
      console.error("Fehler beim Abrufen der Antwort:", error);
    });
}
</script>
<style scoped>
#starter{
  width: 225px;
  height: 50px;
  border: solid black;
}
</style>
