package cloud.sonam.security.pkce.client;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class PkceController {
    private static final Logger LOG = LoggerFactory.getLogger(PkceController.class);

    @GetMapping("/")
    public String index( @RegisteredOAuth2AuthorizedClient("pkce") OAuth2AuthorizedClient authorizedClient) {
        LOG.info("authorized client: {}", authorizedClient);
        LOG.info("principal name: {}", authorizedClient.getPrincipalName());
        LOG.info("auth client accesstoken: {}", authorizedClient.getAccessToken().getTokenValue());
        LOG.info("auth client refresh token: {}", authorizedClient.getRefreshToken().getTokenValue());

        LOG.info("returning index");
        return "index";
    }
}
