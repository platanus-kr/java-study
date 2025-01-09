package org.fundamental.parser;

public class StringTokenizerTest {

	public static final String TEST_CONFIG = "    server {\n" +
			"        client_max_body_size 512M;\n" +
			"        server_name  bbs.canxan.com;\n" +
			"\n" +
			"        #access_log  /var/log/nginx/log/www.example.access.log  main;\n" +
			"        #error_log  /var/log/nginx/log/www.example.error.log;\n" +
			"        root   /usr/share/nginx/html;\n" +
			"        index  noindex;\n" +
			"\n" +
			"        location / {\n" +
			"         proxy_pass  http://bbscanxan;\n" +
			"         proxy_next_upstream error timeout invalid_header http_500 http_502 http_503 http_504;\n" +
			"         proxy_redirect off;\n" +
			"         proxy_buffering off;\n" +
			"         proxy_set_header        Host            $host;\n" +
			"         proxy_set_header        X-Real-IP       $remote_addr;\n" +
			"         proxy_set_header        X-Forwarded-For $proxy_add_x_forwarded_for;\n" +
			"         proxy_set_header        X-Forwarded-Proto $scheme;\n" +
			"       }\n" +
			"\n" +
			"    listen 443 ssl; # managed by Certbot\n" +
			"    ssl_certificate /etc/letsencrypt/live/bbs.canxan.com/fullchain.pem; # managed by Certbot\n" +
			"    ssl_certificate_key /etc/letsencrypt/live/bbs.canxan.com/privkey.pem; # managed by Certbot\n" +
			"    include /etc/letsencrypt/options-ssl-nginx.conf; # managed by Certbot\n" +
			"    ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem; # managed by Certbot\n" +
			"\n" +
			"}\n" +
			"\n" +
			"    upstream bbscanxan  {\n" +
			"          server 9.27.110.198:8080;\n" +
			"    }\n" +
			"\n" +
			"    server {\n" +
			"    if ($host = bbs.canxan.com) {\n" +
			"        return 301 https://$host$request_uri;\n" +
			"    } # managed by Certbot\n" +
			"\n" +
			"\n" +
			"        listen       *:80;\n" +
			"        server_name  bbs.canxan.com;\n" +
			"    return 404; # managed by Certbot\n" +
			"\n" +
			"\n" +
			"}";

}

