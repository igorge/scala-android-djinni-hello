#include "generated/logger.hpp"
#include "generated/hello_world.hpp"
#include "generated/hello_world_maker.hpp"

namespace gie {

    struct HelloWorldImpl : HelloWorld {

        int32_t m_v;
        std::shared_ptr<Logger> m_logger;

        HelloWorldImpl(int32_t v, std::shared_ptr<Logger> const & l) : m_v(v), m_logger(l) {}

        int32_t do_hello_world(const std::string &key) override {
            printf("do_hello_world: %s", key.c_str());
            m_logger->log("hello world from cpp");
            m_logger->log(key);
            return m_v;
        }
        
        ~HelloWorldImpl(){
            m_logger->log("~HelloWorldImpl()");
        }

    };


    std::shared_ptr<HelloWorld> HelloWorldMaker::make(int32_t v, std::shared_ptr<Logger> const & l) {

        return std::make_shared<HelloWorldImpl>(v, l);

    }
}
