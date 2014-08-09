package com.ofg.microservice.facebook

import org.springframework.social.connect.Connection
import org.springframework.social.facebook.api.Facebook
import org.springframework.social.facebook.connect.FacebookConnectionFactory
import org.springframework.social.oauth2.AccessGrant
import spock.lang.Specification

class FacebookAuthSpec extends Specification {

    def 'should create authorized facebook instance'() {
        given:
            Facebook facebook = facebook();
        expect:
            facebook.isAuthorized()
    }

    def 'qqq'(){
        given:
            FacebookRepository repository = new FacebookRepository(facebook())
        when:
            FacebookData data = repository.loadFacebookData('1795620771', 111L)
        then:
            data.profile != null
    }

    Facebook facebook(){
        FacebookConnectionFactory facebookConnectionFactory = new FacebookConnectionFactory("608349685951440","b0c69eb0c633f937ebbda2728a85276e");
        Connection<Facebook> connection = facebookConnectionFactory.createConnection(
                new AccessGrant("CAAIpSnLuK9ABAETTr22p6bepCJw13kAlSfUSfpZBUgoyJMghNl2QBNipC5rDsC9GMdSwdWBm5cOIJ6bRZBdAbpGjA2F6KwtPsJAf2ToZCgp751xVPQLVjVCrN1nPmDctGFVNlsX77kfZAsv4aWD8rtU1JqqimM5Py3QjSPcxoEWiVAD43D0rVHWZBlWGDbrWZAtFSuNZB6l8fmbPfbt49xs"));
        return connection.getApi();
    }
}
