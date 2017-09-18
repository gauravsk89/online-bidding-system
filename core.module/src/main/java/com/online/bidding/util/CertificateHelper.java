package com.online.bidding.util;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CertificateHelper {

    public static List<PublicKey> fetchPublicKeysForIssuer(String host, int port){

        List<PublicKey> publicKeyList = new ArrayList<>();

        try {
            SSLSocketFactory factory = HttpsURLConnection.getDefaultSSLSocketFactory();

            log.debug("Creating a SSL Socket for {} on port {}", host, port);
            SSLSocket socket = (SSLSocket) factory.createSocket(host, 443);
            try {
                socket.startHandshake();
                log.debug("Handshaking Complete");
            }catch (Exception e){
                log.error("Error retrieving public keys from {}:{}", host, port);
                e.printStackTrace();
            }

            Certificate[] serverCerts = socket.getSession().getPeerCertificates();
            log.debug("{} Certificate retrieved from {}:{}", serverCerts.length, host, port);

            for (int i = 0; i < serverCerts.length; i++) {
                Certificate myCert = serverCerts[i];
                publicKeyList.add(myCert.getPublicKey());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return publicKeyList;
    }

    private static class SavingTrustManager implements X509TrustManager {

        private final X509TrustManager tm;
        private X509Certificate[] chain;

        SavingTrustManager(X509TrustManager tm) {
            this.tm = tm;
        }

        public X509Certificate[] getAcceptedIssuers() {
            throw new UnsupportedOperationException();
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            throw new UnsupportedOperationException();
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
            this.chain = chain;
            tm.checkServerTrusted(chain, authType);
        }
    }
}
