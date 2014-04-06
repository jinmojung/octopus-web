
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

environments {
    development {
        dataSource {
			pooled = true
		    dbCreate = "update"
		    url = "jdbc:mysql://211.110.140.104/octopus?useUnicode=yes&characterEncoding=UTF-8"
		    driverClassName = "com.mysql.jdbc.Driver"
		    username = "1111"
		    password = "2222"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            jndiName = "java:comp/env/octopus-db"
        }
    }
}
