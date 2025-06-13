            }
        })
        self.assertEqual(self._ordered(json.loads(r)), self._ordered(json.loads(expect)))

    def test_req_5(self):
        r = ETLClient().run(DocumentService(10), 10)
        expect = [
            json.dumps({
                'doc-count': 2,
                'error-count': 0,
                'docs': {
                    'f01dba4999266bff87400756e8830528': "aliquid cum ut labore nesciunt voluptatibus eius fugiat sunt not error nulla vitae rerum".split(),
                    '87e8d5ee79eb735b2e4e4fb88a9438e9': "nihil natus voluptatibus aperiam quo".split()
                }
            }),
            json.dumps({
                'doc-count': 2,
                'error-count': 1,
                'docs': {