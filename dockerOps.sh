docker build . -t abacus-ms-invoice-claims-mover:latest 

docker tag abacus-ms-invoice-claims-mover:latest  192.180.4.122:5000/abacus-ms-invoice-claims-mover:latest

docker push 192.180.4.122:5000/abacus-ms-invoice-claims-mover:latest 

echo "Enter your message"