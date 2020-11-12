#!/usr/bin/env sh
set -euo pipefail

export KUBECONFIG=$(pwd)/kubeconfig.yml
export GOOGLE_CREDENTIALS="/root/service-account.json"

cat << EOF > ${GOOGLE_CREDENTIALS}
${GCLOUD_SERVICE_ACCOUNT}
EOF

gcloud auth activate-service-account --key-file ${GOOGLE_CREDENTIALS}
gcloud container clusters get-credentials ${GKE_CLUSTER_NAME} --region ${GKE_CLUSTER_REGION} --project ${GCLOUD_PROJECT_ID}

echo "Verifying connectivity to GKE cluster..."
kubectl get nodes --request-timeout 5s

cp kubeconfig.yml ../kubeconfig/
