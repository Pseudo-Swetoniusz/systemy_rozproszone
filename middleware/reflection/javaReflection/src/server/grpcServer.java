package server;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

public class grpcServer {

    private static final Logger logger = Logger.getLogger(grpcServer.class.getName());

    private int port = 50051;
    private Server server;

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(this.port).executor(Executors.newFixedThreadPool(16))
                .addService(new AuthorInfoImpl())
                .addService(ProtoReflectionService.newInstance())
                .build()
                .start();
        System.out.println("Server started, listening on " + this.port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                grpcServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final grpcServer server = new grpcServer();
        server.start();
        server.blockUntilShutdown();
    }
}
