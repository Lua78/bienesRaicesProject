const routes = [
  {
    path: "/",
    component: () => import("layouts/MainLayout.vue"),
    children: [
      { path: "", component: () => import("pages/MainCustomerPage.vue") },
    ],
  },
  {
    path: "/admin",
    component: () => import("layouts/EmptyLayout.vue"),
    children: [
      { path: "login", component: () => import("pages/LoginPage.vue") },
      { path: "recovery", component: () => import("pages/RecoveryPage.vue") },
      { path: "reset", component: () => import("pages/ResetPasswordPage.vue") }
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: "/:catchAll(.*)*",
    component: () => import("pages/ErrorNotFound.vue"),
  },
];

export default routes;
