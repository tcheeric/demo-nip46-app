package nostr.nip46.app;

import lombok.extern.java.Log;
import nostr.base.PublicKey;
import nostr.si4n6r.shibboleth.AppService;
import nostr.si4n6r.shibboleth.Application;

@Log
public class DemoClient {

    public static final PublicKey NOSTR_USER = new PublicKey("f2798137377d60e281a598a8abf1be68d89a4936d55be1a25ec238fdb2cad35c");
    //nsec1lxajhfuzh02ylfytsqjlrjld2lhxn55gzlp3e4jh5q80ft3x56hql9tr4w

    public static void main(String[] args) {
        var app = Application.getInstance();
        app.setUser(NOSTR_USER);

        // TODO - Put in config file?
        var signer = new PublicKey("9cb64796ed2c5f18846082cae60c3a18d7a506702cdff0276f86a2ea68a94123");

        var service = AppService.getInstance(app, signer);

        log.info("Connecting to the signer...");
        service.connect();

        log.info("Describe...");
        service.describe();
    }
}
