FROM 172.16.1.214:31104/socialinvoice/base:v2.11191055

WORKDIR /app/etax-datapool

ADD . /app/etax-datapool

RUN cp target/*.jar /app/etax-datapool/app.jar && \
    chmod +x /app/etax-datapool/docker-entrypoint.sh

EXPOSE 8080

ENTRYPOINT ["/app/etax-datapool/docker-entrypoint.sh"]